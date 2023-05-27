import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import Dropdown from 'react-bootstrap/Dropdown';
import Button from 'react-bootstrap/Button';
import { setEntityMenuParams } from '../store/actions/setEntityMenuParams';

import { getEntities, getEntityEndpointMapping, getEntityFields, getQueriesEndpointMapping, getQueryParams } from '../api_utils.js';
import { setDisplayedEntities } from '../store/actions/setDisplayedEntities';
import { setCurrentEntityEndpoint } from '../store/actions/setCurrentEntityEndpoint';
import { setCurrentQueryEndpoint } from '../store/actions/setCurrentQueryEndpoint';
import { executeQuery } from '../api_utils.js';

export default function ControlPanel() {

    const dispatch = useDispatch();

    let [entityMapping, setEntityMapping] = useState(null);
    let [queryMapping, setQueryMapping] = useState(null);
    let currentEntityEndpoint = useSelector(state => state.currentEntityEndpoint);
    let displayedEntities = useSelector(state => state.displayedEntities);

    useEffect(() => {
        getEntityEndpointMapping().then(response => {
            response.json().then(json => {
                setEntityMapping(json);
            })
        });
        getQueriesEndpointMapping().then(response => {
            response.json().then(json => {
                setQueryMapping(json);
            })
        })
    }, [])

    let entityDropdownItems = []
    for (const entity in entityMapping) {
        const item = <Dropdown.Item eventKey={entityMapping[entity]} key={entityMapping[entity]}>{entity}</Dropdown.Item>;
        entityDropdownItems.push(item);
    }

    let queryDropdownItems = []
    for (const query in queryMapping) {
        const item = <Dropdown.Item eventKey={queryMapping[query]} key={queryMapping[query]}>{query}</Dropdown.Item>;
        queryDropdownItems.push(item);
    }

    const addOnClick = () => {
        getEntityFields(currentEntityEndpoint).then(response => {
            if (response.status === 200) {
                response.json().then(json => {
                    console.log(json);
                    let object = {}
                    json.forEach(field => object[field] = '')
                    dispatch(setEntityMenuParams({
                        show: true,
                        object: object,
                        actions: {
                            add: true,
                            update: false,
                            delete: false,
                            execute: false
                        }
                    }));
                })
            } else {
                console.log(response.status);
            }
        })
    }

    const onEntitySelect = (endpoint) => {
        dispatch(setCurrentEntityEndpoint(endpoint));
        getEntities(endpoint).then((response) => {
            if (response.status === 200) {
                response.json().then((json) => {
                    dispatch(setDisplayedEntities({entities: json, modifiable: true}));
                })
            } else {
                console.log(response.status);
            }
        })
    }

    const onQuerySelect = (endpoint) => {
        console.log(endpoint);
        dispatch(setCurrentQueryEndpoint(endpoint));
        getQueryParams(endpoint).then(response => {
            if (response.status === 200) {
                response.json().then(json => {
                    if (json.length === 0) {
                        executeQuery(endpoint).then(response => {
                            if (response.status === 200) {
                                response.json().then(json => {
                                    dispatch(setDisplayedEntities({entities: json, modifiable: false}));
                                });
                            } else {
                                console.log(response.status);
                            }
                        })
                    } else {
                        let object = {};
                        json.forEach(field => object[field] = '');
                        dispatch(setEntityMenuParams({
                            show: true,
                            object: object,
                            actions: {
                                add: false,
                                update: false,
                                delete: false,
                                execute: true
                            }
                        }));
                    }
                    
                })
            } else {
                console.log(response.status);
            }
        })
    }

    return (
        <div id="ControlPanel">
            <Dropdown onSelect={onEntitySelect}>
                <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                    Сущности
                </Dropdown.Toggle>
                <Dropdown.Menu>
                    {entityDropdownItems}
                </Dropdown.Menu>
            </Dropdown>
            <Dropdown onSelect={onQuerySelect}>
                <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                    Запросы
                </Dropdown.Toggle>
                <Dropdown.Menu>
                    {queryDropdownItems}
                </Dropdown.Menu>
            </Dropdown>
            <Button variant='secondary'
                    onClick={addOnClick}
                    disabled={!displayedEntities.modifiable}>Добавить</Button>
        </div>
    );

}