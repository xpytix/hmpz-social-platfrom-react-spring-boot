import axios from "axios";
import AuthService from "./auth.service";
const API_URL = "http://localhost:3000/api/v1/";

const getPublicContentPost = () => {
  return axios.get(API_URL + "post");
};
const getPublicContentPostAll = () => {
    return axios.get(API_URL + "post/getAll");
  };
  const getPublicContentTrendPost = () => {
    return axios.get(API_URL + "post/trend");
  };
  
const postCreatePost = (data, user) => {
    console.log(data);
  return axios.post(API_URL + "post/" + user.id, data);
};
const getModeratorBoard = () => {
  return axios.get(API_URL + "mod");
};
const getAdminBoard = () => {
  return axios.get(API_URL + "admin");
};
const PostService = {
    getPublicContentPost,
    postCreatePost,
  getModeratorBoard,
  getPublicContentTrendPost,
  getAdminBoard,
} 
export default PostService;