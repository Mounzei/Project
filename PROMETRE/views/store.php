<div class="form">
    <form action="../ajouterUnTravail/store.php" method="post">
        <div>
            <label for="id">ID</label>
            <input type="text" name="id" id="id" required>
        </div>
        <div>
            <label for="nom">nom</label>
            <input type="text" name="nom" id="nom" required>
        </div>
        <div>
            <label for="materiel">Matériel</label>
            <select name="materiel" id="materiel" required>
                <option value="">--Veillez choisir dans la liste--</option>
                <option value="RAS">RAS</option>
                <option value="Harnais de sécurité">Harnais de sécurité</option>
                <option value="Echafaudage">Echafaudage</option>
                <option value="Nacelle">Nacelle</option>
                <option value="Gazelle">Gazelle</option>
            </select>
            <input type="text" name="autremateriel" id="autremateriel" placeholder="Autre">
        </div>
        <div>
            <label for="acces">Accès</label>
            <select name="acces" id="acces" required>
                <option value="">--Veillez choisir dans la liste--</option>
                <option value="RAS">RAS</option>
                <option value="Ascenseur">Ascenseur</option>
                <option value="Echelle">Echelle</option>
            </select>
            <input type="text" name="autreacces" id="autreacces" placeholder="Autre">
        </div>
        <div>
            <label for="nomprojet">Manutention</label>
            <div>
                <input type="checkbox" id="c" name="c" value="Cordages">
                <label for="c">Cordages</label>
            </div>
            <div>
                <input type="checkbox" id="emc" name="emc" value="Elévateur monte charge">
                <label for="emc">Elévateur monte charge</label>
            </div>
            <div>
                <input type="checkbox" id="e" name="e" value="Elévateur">
                <label for="e">Elévateur</label>
            </div>
            <div>
                <input type="checkbox" id="cv" name="cv" value="Chariot à ventouses">
                <label for="cv">Chariot à ventouses</label>
            </div>
        </div>
        <div>
            <label for="as">Dèpose d'un ancien store ?</label>
            <select name="as" id="as" required>
                <option value="">--Veillez choisir dans la liste--</option>
                <option value="oui">OUI</option>
                <option value="non">NON</option>
            </select>
        </div>
        <div>
            <label for="qas">Si oui pour la question d'avant :</label>
            <select name="qas" id="qas">
                <option value="">--Veillez choisir dans la liste--</option>
                <option value="enlevement">Enlèvement par nos soins ?</option>
                <option value="conservation">Conservation par le client ? </option>
            </select>
        </div>
        <div>
            <input type="submit" value="Enregistrer">
        </div>
        <?php if(isset($erreur) && $erreur){?>
            <p>Vous avez deja un travail dans ce projet avec le même id</p>
        <?php }else if(isset($erreurProjet) && !$erreur){ ?>
            <p>Ajout effectué avec succés</p>
        <?php } ?>
    </form>
</div>