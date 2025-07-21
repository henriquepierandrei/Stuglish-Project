import React from 'react';
import './Body.css'; // You should move the CSS to a separate file
import logo from '../../assets/logo.png'; // Importando o logo

function Body() {
    return (
        <div className="cover">
                        <img src={logo} alt="" className='logo-image-2' />

            <div className="cover-inner">
                <div className="glowing"></div>
                <span style={{ "--i": 1 } as React.CSSProperties}></span>
                <span style={{ "--i": 2 } as React.CSSProperties}></span>
                <span style={{ "--i": 3 } as React.CSSProperties}></span>
                <span style={{ "--i": 4 } as React.CSSProperties}></span>
            </div>

            <div className="glowing">
                <span style={{ "--i": 1 } as React.CSSProperties}></span>
                <span style={{ "--i": 2 } as React.CSSProperties}></span>
                <span style={{ "--i": 3 } as React.CSSProperties}></span>
            </div>

            <div className="glowing">
                <span style={{ "--i": 1 } as React.CSSProperties}></span>
                <span style={{ "--i": 2 } as React.CSSProperties}></span>
                <span style={{ "--i": 3 } as React.CSSProperties}></span>
            </div>

            <div className="glowing">
                <span style={{ "--i": 1 } as React.CSSProperties}></span>
                <span style={{ "--i": 2 } as React.CSSProperties}></span>
                <span style={{ "--i": 3 } as React.CSSProperties}></span>
            </div>
        </div>
       
    );
}

export default Body;
