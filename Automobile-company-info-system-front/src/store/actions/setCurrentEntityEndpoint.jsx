export const SET_CURRENT_ENTITY_ENDPOINT = 'SET_CURRENT_ENTITY_ENDPOINT'

export function setCurrentEntityEndpoint(endpoint) {
    return {
        type: SET_CURRENT_ENTITY_ENDPOINT,
        endpoint: endpoint
    }
}