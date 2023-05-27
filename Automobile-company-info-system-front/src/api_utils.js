const URLS = {
    host: "http://10.0.0.3:8080"
}

function sendQuery(URL, method) {
    return fetch(URL, {
        method: method
    })
}

function sendJSONQuery(URL, method, data) {
    return fetch(URL, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
}

function makeURL(endpoint) {
    return `${URLS.host}${endpoint}`
}

export function getEntities(endpoint) {
    return sendQuery(makeURL(endpoint), 'GET');
}

export function postEntity(endpoint, entity) {
    return sendJSONQuery(makeURL(endpoint), 'POST', entity);
}

export function deleteEntity(endpoint, id) {
    endpoint += `?id=${id}`;
    return sendQuery(makeURL(endpoint), 'DELETE');
}

export function updateEntity(endpoint, entity) {
    return sendJSONQuery(makeURL(endpoint), 'PUT', entity);
}

export function getEntityEndpointMapping() {
    return sendQuery(makeURL('/entities'), 'GET');
}

export function getQueriesEndpointMapping() {
    return sendQuery(makeURL('/queries'), 'GET');
}

export function getEntityFields(endpoint) {
    return sendQuery(makeURL(endpoint + '/fields'), 'GET');
}

export function getQueryParams(endpoint) {
    return sendQuery(makeURL(endpoint + '/params'), 'GET');
}

export function executeQuery(endpoint) {
    return sendQuery(makeURL(endpoint), 'GET');
}