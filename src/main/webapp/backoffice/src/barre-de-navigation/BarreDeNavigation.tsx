import React from 'react';
import Toolbar from "@mui/material/Toolbar";
import AppBar from "@mui/material/AppBar";
import './BarreDeNavigation.css';
import {Titre} from "./Titre";

export const BarreDeNavigation = () => {
    return (
        <AppBar position="fixed">
            <Toolbar>
                <div className="AppBarContenu">
                    <Titre/>
                </div>
            </Toolbar>
        </AppBar>
    );
};