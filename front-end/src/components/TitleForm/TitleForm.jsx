import React, { useState, useEffect } from "react";
import axios from "axios";
import "./TitleForm.scss";

function TitleForm(props) {
  const baseURL = "http://localhost:8090/form";
  const [showWarning, setShowWarning] = useState(false);
  const [isFormEmpty, setIsFormEmpty] = useState(false);

  function handleSubmit(e) {
    const title = e.target[0].value;

    e.preventDefault();
    if (title.length == 0) {
      setShowWarning(false);
      setIsFormEmpty(true);
    } else {
      setIsFormEmpty(false);
      axios
        .post(baseURL, {
          thread: props.thread,
          title: title,
        })
        .then((response) => {
          if (response.data.success) {
            props.setNewTitle(title);
          } else setShowWarning(true);
        });
    }
  }

  return (
    <div>
      <h2>{props.thread.toUpperCase()}</h2>
      <hr />
      <form className="form" onSubmit={handleSubmit}>
        <label htmlFor="title" className="titleThread">
          Title:
        </label>
        <input
          id="title"
          name="title-thread"
          type="text"
          placehoder="Title of your new thread"
          className="inputThread"
          data-test="titleForm"
        />
        <button className="formBtn" data-test="titleFormBtn">
          OK
        </button>
      </form>
      <p className="warning" hidden={!showWarning}>
        (!) This title already exists!
      </p>
      <p className="warning" hidden={!isFormEmpty}>
        (!) This field is required!
      </p>
    </div>
  );
}

export default TitleForm;
