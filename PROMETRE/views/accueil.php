<div id="accueil">
    <div>
        <a href="projets.php">Mes projets</a>
    </div>
    <div>
        <form action="accueil.php" method="post">
            <div>
                <label for="idProjet">ID projet</label>
                <input type="text" name="idProjet" id="idProjet" required>
            </div>
            <div>
                <label for="nomProjet">Nom projet</label>
                <input type="text" name="nomProjet" id="nomProjet" required>
            </div>
            <div>
                <label for="clientProjet">Client projet</label>
                <input type="text" name="clientProjet" id="clientProjet" required>
            </div>
            <div>
                <label for="refDossier">Référence dossier</label>
                <input type="text" name="refDossier" id="refDossier" required>
            </div>
            <div>
                <label for="telClient">Téléphone client</label>
                <input type="tel" name="telClient" id="telClient" required>
            </div>
            <div>
                <label for="adrChantier">Adresse chantier</label>
                <input type="text" name="adrChantier" id="adrChantier" required>
            </div>
            <div>
                <label for="descriptionprojet">Description projet</label>
                <textarea name="description" id="description" cols="30" rows="10" required></textarea>
            </div>
            <div>
                <input type="submit" value="Enregistrer">
            </div>
            <?php if(isset($erreurProjet) && $erreurProjet){?>
                <p>Vous avez deja un projet avec le meme id</p>
            <?php }else if(isset($erreurProjet) && !$erreurProjet){ ?>
                <p>Ajout effectué avec succés</p>
            <?php } ?>
        </form>
    </div>
</div>