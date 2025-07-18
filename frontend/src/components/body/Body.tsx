import React from 'react';
import './Body.css'; // You should move the CSS to a separate file

function Body() {
    return (
        <div className="cover">
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
