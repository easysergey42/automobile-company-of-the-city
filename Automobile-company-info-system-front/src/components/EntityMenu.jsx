import React from 'react';
import Container from 'react-bootstrap/Container'
import Stack from 'react-bootstrap/Stack'
import Button from 'react-bootstrap/Button'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { useDispatch, useSelector } from 'react-redux';
import { setEntityMenuParams } from '../store/actions/setEntityMenuParams';
import { deleteEntity, executeQuery, postEntity, updateEntity } from '../api_utils';
import { setDisplayedEntities } from '../store/actions/setDisplayedEntities';
import { getEntities } from '../api_utils.js';

export default function EntityMenu() {

    let params = useSelector(state => state.entityMenuParams);
    let object = params.object;

    let currentEntityEndpoint = useSelector(state => state.currentEntityEndpoint);
    let currentQueryEndpoint = useSelector(state => state.currentQueryEndpoint);

    let newObject = structuredClone(object);
    const onInputChange = (field, value) => {
        newObject[field] = value;
    }

    let fieldsRender = []
    for (const field in object) {
        if (field === 'id') {
            continue;
        }
        let columns = [];
        columns.push(<Col key={object[field] + '1'}>{field}</Col>);
        columns.push(<Col key={object[field] + '2'}><input type='text' defaultValue={object[field]} onChange={(e) => onInputChange(field, e.target.value)}/></Col>);
        fieldsRender.push(<Row key={field}>{columns}</Row>);
    }

    const dispatch = useDispatch();

    const closeClick = () => {
        dispatch(setEntityMenuParams({show: false}));
    }

    const updateDisplayedEntities = () => {
        getEntities(currentEntityEndpoint).then((response) => {
            if (response.status === 200) {
                response.json().then((json) => {
                    dispatch(setDisplayedEntities({entities: json, modifiable: true}));
                })
            } else {
                console.log(response.status);
            }
        })
    }

    const addClick = () => {
        postEntity(currentEntityEndpoint, newObject).then(response => {
            if (response.status === 200) {
                updateDisplayedEntities();
                closeClick();
            } else {
                console.log(response.status);
            }
        });
    }

    const updateClick = () => {
        updateEntity(currentEntityEndpoint, newObject).then(response => {
            if (response.status === 200) {
                updateDisplayedEntities();
                closeClick();
            } else {
                console.log(response.status);
            }
        });
    }

    const deleteClick = () => {
        deleteEntity(currentEntityEndpoint, newObject['id']).then(response => {
            if (response.status === 200) {
                updateDisplayedEntities();
                closeClick();
            } else {
                console.log(response.status);
            }
        });
    }

    const executeClick = () => {
        let endpoint = `${currentQueryEndpoint}?`;
        for (const field in newObject) {
            endpoint += `${field}=${newObject[field]}&`
        }
        endpoint.substring(0, endpoint.length - 1);
        executeQuery(endpoint).then(response => {
            if (response.status === 200) {
                response.json().then(json => {
                    console.log(json);
                    dispatch(setDisplayedEntities({entities: json, modifiable: false}));
                    closeClick();
                });
            } else {
                console.log(response.status);
            }
        })
    }

    return (
        <div id="EntityMenu">
            <div id="EntityMenuFields">
                <Container style={{paddingTop: "20px"}}>
                    {fieldsRender}
                </Container>
            </div>
            <div id="EntityMenuButtons">
                <Stack direction='horizontal'>
                    {
                        params.actions.add && 
                        <Button variant="secondary" 
                                style={{marginLeft: "20px"}}
                                onClick={addClick}>Добавить</Button>
                    }

                    {
                        params.actions.update &&
                        <Button variant="secondary" 
                                style={{marginLeft: "20px"}}
                                onClick={updateClick}>Обновить</Button>
                    }

                    {
                        params.actions.delete &&
                        <Button variant="secondary" 
                                style={{marginLeft: "20px"}}
                                onClick={deleteClick}>Удалить</Button>
                    }

                    {
                        params.actions.execute &&
                        <Button variant="secondary" 
                                style={{marginLeft: "20px"}}
                                onClick={executeClick}>Исполнить</Button>
                    }

                    <Button variant="secondary" 
                            style={{marginLeft: "20px"}}
                            onClick={closeClick}>Закрыть</Button>
                </Stack>
            </div>
        </div>
    );

}