export const SET_ENTITY_MENU_PARAMS = 'SET_ENTITY_MENU_PARAMS';

export function setEntityMenuParams(params) {
    return {
        type: SET_ENTITY_MENU_PARAMS,
        params: params
    }
}