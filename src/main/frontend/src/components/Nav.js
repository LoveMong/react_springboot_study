import {Link} from 'react-router-dom';
import React from "react";
import './Nav.css';

const Nav = () => {
    return (
        <div className="navbar">
            <Link className="navbarMenu" to={'/'}>Main</Link>
            <Link className="navbarMenu" to={'/about'}>About</Link>
            <Link className="navbarMenu" to={'/signup'}>SignUp</Link>
        </div>
    );
}

export default Nav;