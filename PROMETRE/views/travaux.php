<div id="travaux">
    <?php foreach ($travaux as $travau) { ?>
    <div>
        <p><?=$travau['nom']?></p>
        <a href="documents.php?numP=<?=$_GET['numP']?>&numT=<?=$travau['id']?>">Génerer les documents</a>
    </div>
    <?php } ?>
</div>