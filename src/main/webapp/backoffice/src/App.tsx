import './App.css'
import {CssBaseline, styled} from "@mui/material";
import {BarreDeNavigation} from "./barre-de-navigation/BarreDeNavigation";
import {useLocalStorage} from "./hooks/useLocalStorage";
import {Login} from "./login/Login";
import {Evenements} from "./evenements/Evenements";

function App() {
    const Root = styled('div')(({theme}) => ({
        display: 'flex'
    }));
    const Content = styled('div')(({theme}) => ({
        flexGrow: 1,
        paddingTop: '84px !important'
    }));
    const Toolbar = styled('div')(({theme}) => ({
        ...theme.mixins.toolbar,
        display: 'flex',
        justifyContent: 'center'
    }));

    const [login, setLogin] = useLocalStorage('login');
    const [password, setPassword] = useLocalStorage('password');

    return (
        <Root>
            <CssBaseline/>
            {(!login || !password) && <Login setLogin={setLogin} setPassword={setPassword}/>}
            {login && password && <>
                <BarreDeNavigation/>
                <Content>
                    <Toolbar>
                        <Evenements/>
                    </Toolbar>
                </Content>
            </>}
        </Root>
    )
}

export default App
