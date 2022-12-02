import React, { useState } from "react";
import "./Dropdown.scss";

function Dropdown(props) {
  const threads = props.threads;
  const handleClickElement = props.handleClickElement;
  return (
    <div className="scroll">
      <div className="dropdown">
        <button type="button" className="dropbtn">
          Create a thread
        </button>
        <div className="content">
          {threads.map((element, index) => (
            <button
              key={index}
              className="thread"
              value={element}
              onClick={handleClickElement}
            >
              {element}
            </button>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Dropdown;
