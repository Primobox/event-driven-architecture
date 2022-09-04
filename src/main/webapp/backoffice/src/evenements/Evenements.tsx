import {useEffect, useState} from "react";
import {API_BASE_URL} from "../main";
import {Box} from "@mui/material";
import {useLocalStorage} from "../hooks/useLocalStorage";

export const Evenements = () => {

    const [evenements, setEvenements] = useState([]);
    const [login] = useLocalStorage('login');
    const [password] = useLocalStorage('password');

    const fetchEvenements = () => {
        fetch(API_BASE_URL + "/evenements", {
            headers: {
                'Authorization': `Basic ${btoa(`${login}:${password}`)}`
            }
        })
        .then(data => data.json())
        .then(evenementsRecus => setEvenements(evenementsRecus));
    }

    useEffect(() => {
        setInterval(fetchEvenements, 5000)
    }, []);

    const Evenement = ({type, date, payload}) => {
        switch(type) {
            case "com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements.InscriptionRealisee":
                return <span>{`[${date}] Le login ${payload.login} s'est inscrit`}</span>
        }
    }

    return (
        <Box
            display="flex"
            flexDirection="column"
            alignItems="center"
            justifyContent="center">
            {evenements.map((evenement, index) => (
                <Evenement
                    key={`${evenement.type}-${index}`}
                    type={evenement.type}
                    date={evenement.date}
                    payload={evenement.evenement}
                />
            ))}
        </Box>
    )
}