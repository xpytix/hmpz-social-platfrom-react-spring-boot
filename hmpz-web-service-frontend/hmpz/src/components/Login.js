import { Button, Input } from "@mui/material";
import React, { useState, useRef } from "react";
import { useNavigate } from 'react-router-dom';
import AuthService from "../services/auth.service";
import { Box, Link } from "@mui/material";
import Register from "./Register";
import { TextField } from "@mui/material";
const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const Login = () => {

  const [data, setData] = useState({
    username: "",
    password: ""
  })
  const [open, setOpen] = useState(false);


  const { username, password } = data;

  const changeHandler = e => {
    setData({ ...data, [e.target.name]: [e.target.value] });
  }

  const submitHandler = e => {
    e.preventDefault();
    console.log(data.username[0]);
    console.log(data.password[0]);

    AuthService.login(data.username[0], data.password[0]).then(() => refreshPage())
  }
  const refreshPage = () => {
    window.location.reload(false);
  }
  return (
    <>

      <Box
        display="flex"
        justifyContent="center"
        alignItems="center"
        minHeight="100vh"
      >
        <form onSubmit={submitHandler}>

          <Input color="success" sx={{ backgroundColor: '#232A2E', borderRadius: 1, fontSize: 16 }}
            fullWidth type="text" placeholder="Login" name="username" value={username} onChange={changeHandler} /><br />

          <Input color="success" sx={{ backgroundColor: '#232A2E', borderRadius: 1, fontSize: 16 }}
            fullWidth type="password" placeholder="Hasło" name="password" value={password} onChange={changeHandler} /><br />

          <Box marginTop={2}>
            <Box textAlign="center">
              <Button color="success" fullWidth sx={{ marginTop: 1, border: "3px solid rgba(68,165,116,0.7)", borderRadius: 1, fontSize: 16 }} type="submit" name="submit">Zaloguj</Button>
            </Box>

            <Box textAlign="center">
              <Button color="success" onClick={() => setOpen(true)} fullWidth sx={{ marginTop: 1, border: "3px solid rgba(68,165,116,0.7)", borderRadius: 1, fontSize: 16 }} type="submit" name="submit">Zarejestruj się</Button>
            </Box>
          </Box>
        </form>
      </Box>
      <Register onClose={() => setOpen(false)} open={open} />
    </>
  );
}

export default Login;