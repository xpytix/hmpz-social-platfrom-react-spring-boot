import React, {useState, useEffect} from 'react'
import CreatePost from './CreatePost'
import MainContent from './MainContent'
import { Container } from '@mui/material'
import { usePromiseTracker } from "react-promise-tracker";
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import {Routes, Route} from 'react-router-dom'
import Login from './Login';
import Post from "./Post";
import PostService from '../services/post.service';

const Main = (props) => {
    const [content, setContent] = useState([]);
    const [user, setUser] = useState();

    const divStyles={
        backgroundColor: 'teal',
        padding: 10,
        marginLeft: 100,
        height: 400,
        width:400
      }
      
    const creatPost =(name, description, file)=>{
        console.log(file);
        PostService.postCreatePost({
          name,
          description
        }, user).then(
          () => {
          },
          (error) => {
            const _content =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
          }
        );
      }

    useEffect(() => {
        const loggedInUser = localStorage.getItem("user");
        if (loggedInUser) {
            const foundUser = JSON.parse(loggedInUser);
            setUser(foundUser);
        }
    }, []);

    useEffect(() => {
        const loggedInUser = localStorage.getItem("user");
        if (loggedInUser) {
            const foundUser = JSON.parse(loggedInUser);
            setUser(foundUser);
        }
        console.log(props.trend);
        if(!props.trend)
        {
        PostService.getPublicContentPost().then(
            (response) => {
                console.log("dzialm")
              setContent(response.data);
            },
            (error) => {
              const _content =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
              setContent(_content);
            }
          )
        }
        else{
          PostService.getPublicContentTrendPost().then(
            (response) => {
                console.log("dzialm")
              setContent(response.data);
            },
            (error) => {
              const _content =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
              setContent(_content);
            }
          )
        }
            

        }, []);

    return (
        <>
    <Container maxWidth="md">
        {user ? <CreatePost creatPost={creatPost}/> : null}
        <MainContent content={content} user={user} />
    </Container>
    </>
)}
export default Main
