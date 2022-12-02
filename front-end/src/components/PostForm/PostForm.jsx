import React, { useState } from "react";
import QuestionMark from "./../../assets/questionmark.png";
import Pencil from "./../../assets/pencil.png";
import Speaker from "./../../assets/speaker.png";
import "./PostForm.scss";

function PostForm(props) {
  const [writeAvailable, setWriteAvailable] = useState(true);
  const [enabledCheckBtn, setEnabledCheckBtn] = useState(false);
  const [enabledSubmitBtn, setEnabledSubmitBtn] = useState(false);
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
  const checkText = () => {
    setEnabledCheckBtn(false);
    setWriteAvailable(false);
    setEnabledSubmitBtn(true);
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("CLICK!");
  };

  return (
    <div>
      <h2>
        {props.thread.toUpperCase()}: {props.title}
      </h2>
      <hr />
      <form className="postForm" onSubmit={handleSubmit}>
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
          disabled={!writeAvailable}
          onChange={isFilled}
        />
        <button
          className="checkBtn"
          onClick={checkText}
          disabled={!enabledCheckBtn}
        >
          CHECK
        </button>
        <button className="submitBtn" disabled={!enabledSubmitBtn}>
          SEND
        </button>
      </form>
      {/* <p className="warning" hidden={!isNewTitle}>
        (!) This title already exists!
      </p> */}
    </div>
  );
}

export default PostForm;
