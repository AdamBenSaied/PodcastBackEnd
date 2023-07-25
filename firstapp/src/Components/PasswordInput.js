import * as React from 'react';
import Box from '@mui/material/Box';
import IconButton from '@mui/material/IconButton';
import Input from '@mui/material/Input';
import FilledInput from '@mui/material/FilledInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormHelperText from '@mui/material/FormHelperText';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import {useEffect} from "react";
import {useState} from "react";

const MAX_LENGTH = 16
const MIN_LENGTH = 6

export default function InputAdornments(props) {
    const [showPassword, setShowPassword] = React.useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event) => {
        event.preventDefault();
    };

    // const [password, setPassword] = useState("");
    const [helperTextMessage, sethelperTextMessage] = useState("Must be under 16 characters");

    useEffect(() => {
        if (props.password.length >= MAX_LENGTH) {
            sethelperTextMessage("16 characters exceeded");
        }
    }, [props.password]);

    useEffect(() => {
        if (props.password.length < MAX_LENGTH && helperTextMessage) {

            sethelperTextMessage("Must be under 16 characters");
        }
    }, [props.password, helperTextMessage]);


    return (
        <Box sx={{display: 'flex', flexWrap: 'wrap'}}>
            <div>
                <FormControl sx={{m: 1, width: '25ch'}} variant="outlined">
                    <InputLabel htmlFor="password">Password</InputLabel>
                    <OutlinedInput
                        value={props.password}
                        onChange={(event => props.setPassword(event.target.value))}
                        error={props.password.length >= MAX_LENGTH ||
                        (props.password.length <= MIN_LENGTH && props.password.length >0)}
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
    );
}