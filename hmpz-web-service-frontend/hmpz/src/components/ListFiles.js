import React, { useEffect } from 'react'
import Box from '@mui/material/Box';
import ImageList from '@mui/material/ImageList';
import ImageListItem from '@mui/material/ImageListItem';
import ImageListItemBar from '@mui/material/ImageListItemBar';
import { Container } from '@mui/material';

const ListFiles = (props) => {

    let file = props.selectedFile;
    console.log('dziala' + file);
    return (
        <Container>
            <ImageList variant="masonry" cols={3} gap={8}>
                <ImageListItem key={file} 
                        sx={{
                        width:"100px",
                        height:"100px",
                        border:"1px solid rgba(68,165,116,0.7)"}}>
                    <img
                        
                        src={URL.createObjectURL(file)}
                        alt={file}
                        loading="lazy"
                    />
                </ImageListItem>

            </ImageList>
        </Container>
    )
}

export default ListFiles