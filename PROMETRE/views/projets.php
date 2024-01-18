<div id="projets">
    <?php foreach ($projets as $projet) { ?>
    <div>
        <div>
            <div><span><?=$projet['nom']?></span><span><?=$projet['coordonneesChantier']?></span></div>
            <div>
                <a href="ajouterTravail.php?numP=<?=$projet['id']?>">Ajouter un travail</a>
                <a href="travaux.php?numP=<?=$projet['id']?>">Listes des travaux</a>
            </div>
        </div>
        <p><?=$projet['description']?></p>
    </div>
    <?php } ?>
</div>