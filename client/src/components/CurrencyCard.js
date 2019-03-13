import React, { Component } from 'react';
import { lookup } from './lookup';
import './CurrencyCard.css';

class CurrencyCard extends Component {

    render() {
        return (
            <div className="ui fluid card">
                <div className="image img-height">    
                    <img src={`images/${this.props.code}-background.jpg`} 
                        alt={`${lookup(this.props.code)}`} />
                </div>
                <div className="content">
                    <div className="header">{lookup(this.props.code)}</div>
                </div>
            </div>
        );
    }
}

export default CurrencyCard;