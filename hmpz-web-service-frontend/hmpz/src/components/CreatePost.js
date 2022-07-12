import { React, useState, useEffect } from "react";
import axios from 'axios';
import PostService from "../services/post.service";
import { Button, Container } from "@mui/material";
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import Post from "./Post";
import { Input } from "@mui/material";
import AuthService from "../services/auth.service";
import { margin } from "@mui/system";
import PhotoCamera from '@mui/icons-material/PhotoCamera';
import ListFiles from "./ListFiles";
import IconButton from '@mui/material/IconButton';

const CreatePost = (props) => {


  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [selectedFile, setSelectedFile] = useState(null);



  const onClick = () => {
    props.creatPost(name, description, selectedFile);
    setName('');
    setDescription('');
    selectedFile(null);

  }

  const handleFileInput = (e) => {

    setSelectedFile(e.target.files[0]);
      console.log(selectedFile);


}

  return (
    <Box className="siemka"
      sx={{
        maxWidth: '100%',
        margin: '35px',

      }}
    >
      <TextField fullWidth
        sx={{ backgroundColor: '#232A2E', borderRadius: 1, fontSize: 40 }}
        multiline
        variant="filled"
        placeholder="Tytuł"
        color="success"
        id="fullWidth" onChange={event => setName(event.target.value)} />

      <TextField
        id="filled-textarea"
        placeholder="Opis"
        fullWidth
        color="success"
        sx={{ backgroundColor: '#232A2E', borderRadius: 1, fontSize: 40 }}
        multiline
        variant="filled"
        onChange={event => setDescription(event.target.value)}
      />
      <Box paddingTop={2}>
            {selectedFile ? <ListFiles selectedFile={selectedFile} /> : null}
            </Box>
      <Box sx={{ display: 'flex' }}>

        <Box padding={1} flex={1}>
          <label htmlFor="contained-button-file">
            <Input onChange={handleFileInput} sx={{ display: 'none' }} accept="image/*" id="contained-button-file" multiple type="file" />
            <Button color="success" sx={{ marginTop: 1, border: "4px dashed rgba(68,165,116,1)", borderRadius: 1, fontSize: 16 }}
              fullWidth component="span">
              <IconButton color="success" aria-label="upload picture" component="span">
                <PhotoCamera sx={{ fontSize: 16 }}/>
              </IconButton>
            </Button>
          </label>
        </Box>
        <Box padding={1} flex={5}>
          <Button color="success" sx={{ marginTop: 1, border: "4px solid rgba(68,165,116,0.7)", borderRadius: 1, fontSize: 16 }}
            fullWidth onClick={onClick}>
                <IconButton color="success" aria-label="upload picture" component="span">
              </IconButton>HMPZ!</Button>
        </Box>
        
      </Box>
    </Box>

  )
}

export default CreatePost;