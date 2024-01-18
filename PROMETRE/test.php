<?php
ob_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>Je suis nlme roi</p>
</body>
</html>

<?php
$content = ob_get_clean();
$output = shell_exec('cat /etc/hosts');
echo "<pre>$output</pre>";
