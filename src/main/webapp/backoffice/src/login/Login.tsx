import {Alert, Box, Button, TextField, Typography} from "@mui/material";
import {useState} from "react";
import {API_BASE_URL} from "../main";

export const Login = ({setLogin, setPassword}) => {
    const [localLogin, setLocalLogin] = useState('');
    const [localPassword, setLocalPassword] = useState('');
    const [erreur, setErreur] = useState('');

    const validerLoginMotDePasse = async () => {
        try {
            const reponseLogin = await fetch(API_BASE_URL + "/login", {
                headers: {
                    'Authorization': `Basic ${btoa(`${localLogin}:${localPassword}`)}`
                }
            });
            if (reponseLogin.ok) {
                setLogin(localLogin);
                setPassword(localPassword);
            } else {
                setErreur('Login ou mot de passe incorrect');
            }
        } catch (e) {
            setErreur('Login ou mot de passe incorrect');
        }
    }

    return (
        <Box
            display="flex"
            justifyContent="center"
            alignItems="center"
            flexDirection="column"
            gap="6px"
            style={{height: '100%', width: '100%'}}>
            <h3>Login</h3>
            {erreur && <Alert severity="error">{erreur}</Alert>}
            <TextField
                id="login"
                label="Login"
                variant="outlined"
                value={localLogin}
                onChange={(event) => setLocalLogin(event.target.value)}/>
            <TextField
                id="password"
                label="Mot de passe"
                type="password"
                variant="outlined"
                value={localPassword}
                onChange={(event) => setLocalPassword(event.target.value)}
            />
            <Button
                style={{marginTop: '10px'}}
                variant="contained"
                onClick={validerLoginMotDePasse}
                disabled={!localLogin || !localPassword}
            >Valider</Button>
        </Box>
    )
}