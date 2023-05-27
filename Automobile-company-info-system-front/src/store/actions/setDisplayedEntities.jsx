export const SET_DISPLAYED_ENTITIES = 'SET_DISPLAYED_ENTITIES'

export function setDisplayedEntities(entities) {
    return {
        type: SET_DISPLAYED_ENTITIES,
        displayedEntities: entities
    }
}