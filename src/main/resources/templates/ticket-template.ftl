<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/2980e116e8.js" crossorigin="anonymous"></script>
    <title>Confirmation E-billet</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Oswald');
        *
        {
            margin: 0;
            padding: 0;
            border: 0;
            box-sizing: border-box
        }

        body
        {
            background-color: #999999;
            font-family: arial
        }

        .fl-left{background-color: #999999;}

        .fl-right{float: right}

        .container
        {
            width: 90%;
            margin: 100px auto
        }

        h1
        {
            text-transform: uppercase;
            font-weight: 900;
            border-left: 10px solid #fec500;
            padding-left: 10px;
            margin-bottom: 30px
        }

        .row{overflow: hidden}

        .card
        {
            display: table-row;
            width: 49%;
            background-color: #fff;
            color: #989898;
            margin-bottom: 10px;
            font-family: 'Oswald', sans-serif;
            text-transform: uppercase;
            border-radius: 4px;
            position: relative
        }

        .card + .card{margin-left: 2%}

        .date
        {
            display: table-cell;
            width: 25%;
            position: relative;
            text-align: center;
            border-right: 2px dashed #dadde6
        }

        .date:before,
        .date:after
        {
            content: "";
            display: block;
            width: 30px;
            height: 30px;
            background-color: #DADDE6;
            position: absolute;
            top: -15px ;
            right: -15px;
            z-index: 1;
            border-radius: 50%
        }

        .date:after
        {
            top: auto;
            bottom: -15px
        }

        .date time
        {
            display: block;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%)
        }

        .date time span{display: block}

        .date time span:first-child
        {
            color: #2b2b2b;
            font-weight: 600;
            font-size: 250%
        }

        .date time span:last-child
        {
            text-transform: uppercase;
            font-weight: 600;
            margin-top: -10px
        }

        .card-cont
        {
            display: table-cell;
            width: 75%;
            font-size: 85%;
            padding: 10px 10px 30px 50px
        }

        .card-cont h3
        {
            color: #3C3C3C;
            font-size: 130%
        }

        .row:last-child .card:last-of-type .card-cont h3
        {
            text-decoration: line-through
        }

        .card-cont > div
        {
            display: table-row
        }

        .card-cont .even-date i,
        .card-cont .even-info i,
        .card-cont .even-date time,
        .card-cont .even-info p
        {
            display: table-cell
        }

        .card-cont .even-date i,
        .card-cont .even-info i
        {
            padding: 5% 5% 0 0
        }

        .card-cont .even-info p
        {
            padding: 30px 50px 0 0
        }

        .card-cont .even-date time span
        {
            display: block
        }

        .card-cont a
        {
            display: block;
            text-decoration: none;
            width: 80px;
            height: 30px;
            background-color: #D8DDE0;
            color: #fff;
            text-align: center;
            line-height: 30px;
            border-radius: 2px;
            position: absolute;
            right: 10px;
            bottom: 10px
        }

        .row:last-child .card:first-child .card-cont a
        {
            background-color: #037FDD
        }

        .row:last-child .card:last-child .card-cont a
        {
            background-color: #F8504C
        }

        @media screen and (max-width: 860px)
        {
            .card
            {
                display: block;
                float: none;
                width: 100%;
                margin-bottom: 10px
            }

            .card + .card{margin-left: 0}

            .card-cont .even-date,
            .card-cont .even-info
            {
                font-size: 75%
            }
        }

    </style>
</head>

<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr ><h1>Confirmation E-Billet</h1></tr>
    <tr>

        <td align="center" valign="top" bgcolor="#838383"
            style="background-color: #838383;"><br> <br>
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <article class="card fl-left">
                        <section class="date" style="width:130px;">
                            <time datetime="23th feb"><br><br><br><br><br>
                                <span style=" color: #2b2b2b;
                                    font-weight: 600;
                                    font-size: 250%;">${jour}</span><span style="  text-transform: uppercase;font-weight: 600;
                                     margin-top: -10px;">${mois}</span>
                            </time>
                        </section>
                        <section class="card-cont">

                            <small style="float:left;">Nom :   </small> <small style="float:left;padding-left: 10px; color:blueviolet;font-weight: bolder;">${nom}</small>
                            <small style="float: right;font-size: 16px;">Montant du voyage    </small><br><br>
                            <small style="float:left;">Prénom :   </small> <small style="float:left;padding-left: 10px;color:blueviolet;font-weight: bolder;">${prenom}</small><small style="float:left;color:#DC143C;font-weight: bolder;font-size: 18px;padding-left:120px;">${prix} DH</small><br><br>
                            <small style="float:left;">Ticket N° :   </small> <small style="float:left;padding-left: 10px; color:blueviolet;font-weight: bolder;">${id}</small><br><br>
                            <small style="float:left;">Ligne N° :   </small> <small style="float:left;padding-left: 10px; color:blueviolet;font-weight: bolder;">${ligne}</small><br/><br/>
                            <h3> &nbsp; &nbsp; ${dep}    &nbsp; &nbsp;    <span style="color:blueviolet">--></span>    &nbsp; &nbsp;    ${des}</h3>
                            <div class="even-date">
                                <i class="fa fa-calendar"></i>
                                <time>
                                    <span style="text-align: center;padding-left:50px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${date}</span>
                                    <span style="text-align: center;padding-left:50px;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${time}</span>
                                </time>
                            </div>
                            <div class="even-info">
                                <i class="fa fa-map-marker"></i>
                                <p Style="text-align: center;">
                                      <span style="text-transform: uppercase;
                                       font-weight: 600;
                                       color:#DC143C;font-weight:bolder;"> #moovitBus Team</span>
                                </p>

                            </div>

                        </section>
                    </article>

                </tr>
            </table> <br> <br></td>
    </tr>
</table>

</body>
</html>
