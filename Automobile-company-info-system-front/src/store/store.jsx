import {configureStore} from "@reduxjs/toolkit";
import {reducer} from "./reducer.jsx";

export let store = configureStore({
    reducer: reducer
});