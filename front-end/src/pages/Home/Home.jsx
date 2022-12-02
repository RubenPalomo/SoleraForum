import React, { useState } from "react";
import Header from "../../components/Header/Header";
import Dropdown from "../../components/Dropdown/Dropdown";
import TitleForm from "../../components/TitleForm/TitleForm";
import PostForm from "../../components/PostForm/PostForm";
import Back from "./../../assets/back.png";
import "./Home.scss";

function Home() {
  const [currentThread, setCurrentThread] = useState();
  const [isOpenThread, setIsOpenThread] = useState(false);
  const [newTitle, setNewTitle] = useState("");
  const threads = ["Football", "Basketball", "Gym", "Swimming"];
  const handleClickElement = (e) => {
    setCurrentThread(e.target.value);
    setIsOpenThread(!isOpenThread);
    setNewTitle("");
  };

  if (!isOpenThread)
    return (
      <div>
        <Header />
        <Dropdown threads={threads} handleClickElement={handleClickElement} />
      </div>
    );
  else {
    if (newTitle == "")
      return (
        <div>
          <Header />
          <div className="scroll">
            <button className="backBtn" onClick={handleClickElement}>
              <img className="backImg" src={Back} />
            </button>
            <TitleForm thread={currentThread} setNewTitle={setNewTitle} />
          </div>
        </div>
      );
    else {
      return (
        <div>
          <Header />
          <div className="scroll">
            <button className="backBtn" onClick={handleClickElement}>
              <img className="backImg" src={Back} />
            </button>
            <PostForm thread={currentThread} title={newTitle} />
          </div>
        </div>
      );
    }
  }
}

export default Home;
