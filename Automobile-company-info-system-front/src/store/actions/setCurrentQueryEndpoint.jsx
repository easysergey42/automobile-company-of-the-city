export const SET_CURRENT_QUERY_ENDPOINT = 'SET_CURRENT_QUERY_ENDPOINT'

export function setCurrentQueryEndpoint(endpoint) {
    return {
        type: SET_CURRENT_QUERY_ENDPOINT,
        endpoint: endpoint
    }
}