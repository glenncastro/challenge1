import { combineReducers } from 'redux';
import currenciesReducer from './currenciesReducer';
import quotesReducer from './quotesReducer';
import profitsReducer from './profitsReducer';

export default combineReducers({
    currencies: currenciesReducer,
    quotes: quotesReducer,
    profits: profitsReducer
});