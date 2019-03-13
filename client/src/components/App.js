import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import CurrencyProfits from './CurrencyProfits';
import CurrencyDetail from './CurrencyDetail';
import CurrencyHome from './CurrencyHome';

const App = () => {
    return(
        <div>
            <BrowserRouter>
                <div>
                    <Route path="/" exact component={CurrencyHome} />
                    <Route path="/profits" exact component={CurrencyProfits} />
                    <Route path="/currencies/:currency" exact component={CurrencyDetail} />
                </div>
            </BrowserRouter>
        </div>
    );
};

export default App;