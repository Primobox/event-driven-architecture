import './App.css'
import {useLocalStorage} from "./hooks/useLocalStorage";
import {Inscription} from "./Inscription";

function App() {
    const [login, setLogin] = useLocalStorage('meetGeekLogin');
    return (
        <>
            {!login && <Inscription setLogin={setLogin}/>}
            {login && <span>Coucou {login} ;-)</span>}
        </>
    )
}

export default App
