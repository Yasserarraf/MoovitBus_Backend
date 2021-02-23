package fstt.lsi.Controller;

import fstt.lsi.entities.Client;
import fstt.lsi.service.InscriptionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InscriptionController {

       @Autowired
        InscriptionService inscriptionService;

       @GetMapping("/getUsers")
        public List<Client> AllClients() {
		return inscriptionService.AllClients();
	}

		@PostMapping("/registerUser")
        public Client registerUser(@RequestBody Client client) throws Exception {
            String checkEmail = client.getEmail();
            String checkPassword = client.getPassword();
            String checkTelephone = client.getNum_tel();
            if (checkEmail != null && !"".equals(checkEmail)) {
                Client userObj = inscriptionService.fetchClientByEmail(checkEmail);
                if (userObj != null) {
                    throw new Exception("User with this Email " + checkEmail + " is Already exist  ");
                }
            }
            if (checkPassword != null && checkPassword.length() < 8)  {
                throw new Exception("The password must contain at least 8 characters, Please try again");
            }
            if (checkTelephone!=null && checkTelephone.length() < 10) {
                throw new Exception("telephone number should contains 10 digits, Please try again");
            }
            Client userObject = null;
            userObject =inscriptionService .saveClient(client);
            return userObject;

        }

        @PostMapping("/LoginUser")
        public Client loginUser(@RequestBody Client client) throws Exception {
            // checking if the user with email,password is present in our db

            String checkEmail = client.getEmail();
            String checkPassword = client.getPassword();
            Client userObject = null;
            if (checkEmail != null && checkPassword != null) {

                userObject = InscriptionService.fetchClientByEmailAndPassword(checkEmail, checkPassword);

            }
            if(userObject==null) { //if the user does not exist throw exception

                throw new Exception(" Bad credentials.Please enter a valid email & password. ");
            }

            return userObject;

        }
    }


