import { Button, Input } from "@mui/material";
import React, { useState, useRef } from "react";
import { useNavigate } from 'react-router-dom';
import AuthService from "../services/auth.service";
import { Box } from "@mui/material";
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const Register = (props) => {

  const [data,setData] = useState({
    username:"",
    email:"",
    password:""
  })
  
  const {username,email, password } = data;
  
  const changeHandler = e => {
    setData({...data,[e.target.name]:[e.target.value]});
  }
  
  const submitHandler = e => {
    e.preventDefault();
    console.log(data.username[0]);
    console.log(data.email[0]);
    console.log(data.password[0]);
    AuthService.register(data.username[0], data.email[0], data.password[0] ).then(()=> refreshPage())
  }
  const refreshPage= ()=> {
    window.location.reload(false);
  }
  return (
    <>
    <Dialog
      open={props.open}
      onClose={props.onClose}
      aria-labelledby="alert-dialog-title"
      aria-describedby="alert-dialog-description"
    >
      <DialogTitle id="alert-dialog-title">
        {"Rejestracja"}
      </DialogTitle>
      <DialogContent>
        <DialogContentText id="alert-dialog-description">
        <Input type="text" placeholder="Login" name="username" value={username} onChange={changeHandler} /><br />
          <Input type="email" placeholder="Email" name="email" value={email} onChange={changeHandler} /><br />
          <Input type="password" placeholder="Hasło" name="password" value={password} onChange={changeHandler} /><br />
         
        </DialogContentText>
      </DialogContent>
      <DialogActions>
        <Button onClick={submitHandler} type="submit" name="submit">Zarejestruj</Button>
        <Button onClick={props.onClose} autoFocus>
          Zamknij
        </Button>
      </DialogActions>
    </Dialog>
    {/* <Box
      display="flex"
      justifyContent="center"
      alignItems="center"
      minHeight="100vh"
    >

          <Input type="text" placeholder="Login" name="username" value={username} onChange={changeHandler} /><br />
          <Input type="text" placeholder="Email" name="Email" value={email} onChange={changeHandler} /><br />
          <Input type="password" placeholder="Hasło" name="password" value={password} onChange={changeHandler} /><br />
          <Button onClick={submitHandler} type="submit" name="submit">Zarejestruj</Button>

      </Box> */}
      </>
       
  );
  }

export default Register;