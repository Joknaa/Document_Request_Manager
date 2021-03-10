<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="./images/favicon.ico"/>
    <title>Espace Etudiant</title>
</head>

<body>
<div style="background-color: #ff9800;">
      <center><img src="./images/logo-ensa.png" alt=""></center>
    </div>
    <center><h1>Renseigner le formulaire suivant pour demander un document:</h1></center>
		<form action="" method="POST">
        <h4>Entrer l'adresse email:</h4>
        <input type="email" style="width:240px" placeholder="Adresse email:" name="EMAIL" required>
        <h4>Entrer le numéro d'apogee:</h4>
        <input type="text" style="width:240px" placeholder="N° Apogée: " name="N_apogee" required>
        <h4>Entrer la CIN:</h4>
        <input type="text" style="width:240px" placeholder="CIN: " name="CIN" required>
        <h4>Choississez le type du document:</h4>
				<select name="type" required aria-invalid="false">
				<option value="" selected>Choix du document: </option>
				<option value="ATTESTATION">Attestation de scolarité</option>
                <option value="RELEVE">Relevé de notes</option>
	        </select>
            <h4></h4>
			<input type="submit" name="submit">
		</form>
		</body>
		<style>     
                body {
                    background-color: #D5C37C;
                }
      </style>
    </html>

	<?php        
            include('./database/dbconnect.php');
             if(isset($_POST["submit"])){
                $email = $_POST["EMAIL"];
                $CIN = $_POST["CIN"];
                $N_APOGEE = $_POST["N_apogee"];
				$type = $_POST["type"];
                $sql = "SELECT EMAIL, CIN FROM student WHERE N_apogee = $N_APOGEE";
                $result = mysqli_query($DBConn,$sql);
                $count = mysqli_num_rows($result);
                while($row = mysqli_fetch_row($result)){ 
                    if($email!=$row[0] || $CIN!=$row[1]){
                        echo "<h3>Invalid information</h3>";
                    }else{
                        $sqlinsert = "INSERT INTO document (N_apogee,type) 
                                        VALUES ($N_APOGEE,'$type')";
                        if (mysqli_query($DBConn, $sqlinsert)) 
                        echo "<h3>La demande de type<font color='red'> $type</font> est ajouté avec succés</h3>";
                        else 
                        echo "Error: " . $sqlinsert . "<br>" . mysqli_error($DBConn);
                    }

                }

				header("Refresh:5; url=etudiant.php");
        }
		
?>