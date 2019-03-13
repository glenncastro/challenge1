export default (state = [], action) => {
    switch(action.type) {
        case 'FETCH_CURRENCY_QUOTES':
            return action.payload;
        default:
            return state;
    }
};