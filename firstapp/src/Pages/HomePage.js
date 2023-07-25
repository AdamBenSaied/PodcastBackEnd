import React from "react";
// import Link from "@mui/material/Link";
import {Link} from "react-router-dom"
export default function Home() {
    return(
        <div className="home">
            <h1>This is the Home page</h1>
            <Link to ="/signup" > Signup</Link>
        </div>
    )
}
