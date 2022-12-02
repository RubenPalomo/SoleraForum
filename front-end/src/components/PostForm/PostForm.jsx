import React, { useState, useEffect } from "react";
import axios from "axios";
import QuestionMark from "./../../assets/questionmark.png";
import Pencil from "./../../assets/pencil.png";
import Speaker from "./../../assets/speaker.png";
import "./PostForm.scss";

function PostForm(props) {
  const baseURL = "http://localhost:8090/form";
  const [writeAvailable, setWriteAvailable] = useState(true);
  const [enabledCheckBtn, setEnabledCheckBtn] = useState(false);
  const [enabledSubmitBtn, setEnabledSubmitBtn] = useState(false);
  const [isAllowed, setIsAllowed] = useState(true);
  const [img, setImg] = useState(QuestionMark);
  const changeImg = (e) => {
    switch (e.target.value) {
      case "doubt":
        setImg(QuestionMark);
        break;
      case "suggestion":
        setImg(Speaker);
        break;
      case "clarification":
        setImg(Pencil);
        break;
    }
  };
  const isFilled = (e) => {
    if (!e.target.value == "") setEnabledCheckBtn(true);
    else setEnabledCheckBtn(false);
  };
  const checkText = (e) => {
    e.preventDefault();
    setEnabledCheckBtn(false);
    setWriteAvailable(false);

    axios
      .post(baseURL, {
        post: e.target[1].value,
      })
      .then((response) => {
        if (!response.data.success) setIsAllowed(false);
        else setEnabledSubmitBtn(true);
      });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("CLICK!");
    props.back();
  };

  return (
    <div>
      <h2>
        {props.thread.toUpperCase()}: {props.title}
      </h2>
      <hr />
      <form className="postForm" onSubmit={checkText}>
        <label htmlFor="category" className="label">
          Category:
        </label>
        <select
          name="category"
          id="category"
          className="selector"
          onChange={changeImg}
        >
          <option value="doubt">{props.thread} doubt</option>
          <option value="suggestion">{props.thread} suggestion</option>
          <option value="clarification">{props.thread} clarification</option>
        </select>
        <img className="image" src={img} />
        <br />
        <textarea
          id="title"
          name="title-thread"
          type="text"
          placehoder="Title of your new thread"
          className="inputText"
          data-test="textArea"
          disabled={!writeAvailable}
          onChange={isFilled}
        />
        <button
          className="checkBtn"
          data-test="checkBtn"
          disabled={!enabledCheckBtn}
        >
          CHECK
        </button>
        <button
          className="submitBtn"
          data-test="submitBtn"
          disabled={!enabledSubmitBtn}
          onClick={handleSubmit}
        >
          SEND
        </button>
        <label htmlFor="public" className="public">
          Public
        </label>
        <input id="public" className="public check" type="checkbox" />
      </form>
      <p className="warning banned" hidden={isAllowed}>
        (!) You have used banned words!
      </p>
    </div>
  );
}

export default PostForm;
