import { SET_DISPLAYED_ENTITIES } from "./actions/setDisplayedEntities.jsx"
import { SET_CURRENT_ENTITY_ENDPOINT } from "./actions/setCurrentEntityEndpoint.jsx"
import { SET_ENTITY_MENU_PARAMS } from "./actions/setEntityMenuParams.jsx"
import { SET_CURRENT_QUERY_ENDPOINT } from "./actions/setCurrentQueryEndpoint.jsx"

let initialState = {
    displayedEntities: {
        entities: [],
        modifiable: false
    },
    entityMenuParams: {
        show: false,
        object: null,
        actions: {
            add: false,
            update: false,
            delete: false,
            execute: false
        }
    },
    currentEntityEndpoint: null,
    currentQueryEndpoint: null
}

export function reducer(state = initialState, action) {
    switch (action.type) {
        case SET_ENTITY_MENU_PARAMS:
            return {
                ...state,
                entityMenuParams: action.params
            }
        case SET_DISPLAYED_ENTITIES:
            return {
                ...state,
                displayedEntities: action.displayedEntities
            }
        case SET_CURRENT_ENTITY_ENDPOINT:
            return {
                ...state,
                currentEntityEndpoint: action.endpoint
            }
        case SET_CURRENT_QUERY_ENDPOINT:
            return {
                ...state,
                currentQueryEndpoint: action.endpoint
            }
        default: 
            return {
                ...state
            }
    }
}