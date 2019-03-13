export default (state = [], action) => {
    switch(action.type) {
        case 'FETCH_PROFITS':
            return action.payload;
        default:
            return state;
    }
};