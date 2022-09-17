import {Alert, Box, Button, Snackbar, TextField, Typography} from "@mui/material";
import {useState} from "react";
import './Inscription.css';
import {BASE_API_URL} from "./main";

interface InscriptionProps {
    setLogin: Function;
}

export const Inscription = ({setLogin}: InscriptionProps) => {
    const [localLogin, setLocalLogin] = useState<string>('');
    const [erreurAffichee, setErreurAffichee] = useState(false);
    const [erreur, setErreur] = useState<string | null>(null);

    const inscription = () => {
        if (localLogin && localLogin.trim() !== '') {
            // Appel back
            fetch(BASE_API_URL + "/api/inscriptions", {
                method: 'POST',
                headers: {
                    "Accept": "application/json",
                    "Content-Type": "application/json"
                },
                body: `{"login":"${localLogin}"}`
            }).then(resultat => {
                if (resultat.ok) {
                    setLogin(localLogin);
                } else {
                    setErreur('Vous ne pouvez pas vous inscrire avec ce login');
                    setErreurAffichee(true);
                }
            })
        } else {
            setErreur('Le login est obligatoire');
            setErreurAffichee(true);
        }
    }

    return <Box
        display="flex"
        flexDirection="column"
        justifyContent="center"
        alignItems="center"
        gap="10px"
        sx={{
            height: '100%',
            width: '100%'
        }}
    >
        <Typography variant="h3">
            Bienvenue dans l'application ❤️ <span>MeetGeek</span> ❤️
        </Typography>
        <Typography variant="h5">
            Des d&eacute;veloppeurs c&eacute;libataires sont &agrave; port&eacute;e de clic ;-)<br/>
            Pour vous inscrire, veuillez saisir un login :
        </Typography>
        <TextField
            id="meetGeekLogin"
            label="Login"
            variant="outlined"
            value={localLogin}
            onChange={event => setLocalLogin(event.target.value)}
        />
        <Button
            variant="contained"
            onClick={inscription}
        >S'inscrire</Button>
        {erreur && <Snackbar
            open={erreurAffichee}
            autoHideDuration={6000}
            onClose={() => setErreurAffichee(false)}>
            <Alert
                onClose={() => setErreurAffichee(false)}
                severity="error"
                sx={{width: '100%'}}
                variant="filled"
            >
                {erreur}
            </Alert>
        </Snackbar>}
    </Box>;
}