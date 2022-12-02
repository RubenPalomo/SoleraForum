import React, { useState } from "react";
import "./TitleForm.scss";

function TitleForm(props) {
  const [isNewTitle, setIsNewTitle] = useState(false);
  const [isFormEmpty, setIsFormEmpty] = useState(false);
  const titles = [
    "Messi y la magia",
    "Lo que se metía Ronaldinho",
    "Roban el SUUUUUUU al bicho",
  ];
  const handleSubmit = (e) => {
    e.preventDefault();
    if (e.target[0].value.length == 0) {
      setIsNewTitle(false);
      setIsFormEmpty(true);
    } else if (titles.includes(e.target[0].value)) {
      setIsNewTitle(true);
      setIsFormEmpty(false);
    } else {
      setIsNewTitle(false);
      setIsFormEmpty(false);
      props.setNewTitle(e.target[0].value);
    }
  };

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
        />
        <button className="formBtn">OK</button>
      </form>
      <p className="warning" hidden={!isNewTitle}>
        (!) This title already exists!
      </p>
      <p className="warning" hidden={!isFormEmpty}>
        (!) This field is required!
      </p>
    </div>
  );
}

export default TitleForm;
