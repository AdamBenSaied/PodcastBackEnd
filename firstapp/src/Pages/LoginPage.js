import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import logoImage from '../Medias/Images/PodcastLogo.png'
import Container from "@mui/material/Container";
import Paper from "@mui/material/Paper";
import {useState} from "react";
import Button from "@mui/material/Button";
import {Link} from "react-router-dom";
import EmailInput from "../Components/EmailInput";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import OutlinedInput from "@mui/material/OutlinedInput";
import InputAdornment from "@mui/material/InputAdornment";
import IconButton from "@mui/material/IconButton";
import VisibilityOff from "@mui/material/SvgIcon/SvgIcon";
import {Visibility} from "@mui/icons-material";




export default function LoginForm(props) {
    const paperStyle = {padding: "20px 50px", width: 500, margin: "20px auto"}
    const imageStyle = {margin: "30px auto"}
    const textField = {marginBottom: "20px"}
    const links = {margin: "20 px auto", padding: "20px 32px", width: 500}
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [showPassword, setShowPassword] = React.useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };


    const handleClick = (e) => {
        e.preventDefault()
        const user = {email, password}
        console.log(user)
    }

    return (
        <Box
            component="form"
            sx={{
                '& > :not(style)': {
                    m: 1,
                },
            }}
            noValidate
            autoComplete="off"
        >
            <Container>
                <Paper elevation={3} style={paperStyle}>
                    <h4> Login page</h4>
                    <img src={logoImage} style={imageStyle}/>

                    <Box
                        component="form"
                        sx={{
                            '& .MuiTextField-root': {m: 1, width: '25ch'},
                        }}
                        noValidate
                        autoComplete="off"
                    >
                        <div>
                            <TextField
                            required={true}
                            label="email"
                            value={props.email}
                            onChange={(event) => setEmail(event.target.value)}
                        />

                        </div>
                    </Box>

                    <Box sx={{display: 'flex', flexWrap: 'wrap'}}>
                        <div>
                            <FormControl sx={{m: 1, width: '25ch'}} variant="outlined">
                                <InputLabel htmlFor="password">Password</InputLabel>
                                <OutlinedInput
                                    value={props.password}
                                    onChange={(event => setPassword(event.target.value))}
                                    id="password"
                                    type={showPassword ? 'text' : 'password'}
                                    endAdornment={
                                        <InputAdornment position="end">
                                            <IconButton
                                                aria-label="toggle password visibility"
                                                onClick={handleClickShowPassword}
                                                onMouseDown={handleMouseDownPassword}
                                                edge="end"
                                            >
                                                {showPassword ? <VisibilityOff/> : <Visibility/>}
                                            </IconButton>
                                        </InputAdornment>
                                    }
                                    label="Password"
                                />
                            </FormControl>
                        </div>
                    </Box>


                    <Button variant="contained" color="secondary" onClick={handleClick}>Login</Button>
                    <br></br>


                    <Link to="/signup" underline="always" style={links}>
                        {"Not a member yet ?"}
                    </Link>

                    <Link to="/forgotpassword" underline="always" style={links}>
                        {"Forgot password ?"}
                    </Link>


                </Paper>

            </Container>
        </Box>
    );
}