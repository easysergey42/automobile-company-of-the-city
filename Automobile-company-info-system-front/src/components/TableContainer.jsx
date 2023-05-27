import Table from 'react-bootstrap/Table'
import { useDispatch, useSelector } from 'react-redux';
import { setEntityMenuParams } from '../store/actions/setEntityMenuParams';

export default function TableContainer() {

    const dispatch = useDispatch();

    const displayedEntities = useSelector(state => state.displayedEntities);

    let columnsRender = [];
    let objectsRender = [];
    if (displayedEntities.entities) {
        let columnNames = []
        for (const name in displayedEntities.entities[0])
            columnNames.push(name);

        columnsRender = columnNames.map((name) => <th>{name}</th>)
        displayedEntities.entities.forEach(obj => {
            let objectRender = [];
            columnNames.forEach(column => {
                objectRender.push(<td>{obj[column]}</td>)
            });
            objectRender.obj = obj;
            objectsRender.push(<tr onClick={() => onRowClick(obj)} obj={obj}>{objectRender}</tr>)
        });
    }

    let onRowClick = (obj) => {
        if (!displayedEntities.modifiable) {
            return;
        }
        dispatch(setEntityMenuParams({
            show: true,
            object: obj,
            actions: {
                add: true,
                update: true,
                delete: true,
                execute: false
            }
        }))
    }

    return (
        <div id="TableContainer">
            <Table striped bordered hover variant='dark'>
                <thead>
                    <tr>
                        {columnsRender}
                    </tr>
                </thead>
                <tbody>
                    {objectsRender}
                </tbody>
            </Table>
        </div>
    );

}