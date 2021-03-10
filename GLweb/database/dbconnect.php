<?php

$DBServer = "localhost";
$DBUser = "root";
$DBPassword = "lolilol123";
$DBName = "database";

$DBConn = mysqli_connect($DBServer, $DBUser, $DBPassword, $DBName);


if (!$DBConn) {
    die("Connection failed: " . mysqli_connect_error());
  }


?>

