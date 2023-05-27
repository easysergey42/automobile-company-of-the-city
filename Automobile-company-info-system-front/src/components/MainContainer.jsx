import React from 'react'
import TableContainer from './TableContainer.jsx';
import ControlPanel from './ControlPanel.jsx';
import EntityMenu from './EntityMenu.jsx';
import { useSelector } from 'react-redux';

export default function MainContainer() {

    let showMenu = useSelector(state => state.entityMenuParams.show);

    return (
        <div id="MainContainer">
            <TableContainer />
            <ControlPanel />
            {
                showMenu &&
                <EntityMenu />
            }
        </div>
    );

}