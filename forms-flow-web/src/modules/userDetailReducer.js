import ACTION_CONSTANTS from "../actions/actionConstants";
import { setShowApplications, setUserRolesToObject } from "../helper/user";
import { LANGUAGE } from "../constants/constants";
import { setFormAndSubmissionAccess } from "../helper/access";

const getLanguages = localStorage.getItem("languages");

const roleIdsFromLocalStorage = localStorage.getItem("roleIds")
  ? JSON.parse(localStorage.getItem("roleIds"))
  : undefined;

const initialState = {
  bearerToken: localStorage.getItem("authToken"),
  refreshToken: localStorage.getItem("refreshToken"),
  tokenParsed: null,
  roles: "",
  roleIds: roleIdsFromLocalStorage
    ? setUserRolesToObject(roleIdsFromLocalStorage)
    : {},
  formAccess: roleIdsFromLocalStorage
    ? setFormAndSubmissionAccess("formAccess", roleIdsFromLocalStorage)
    : [],
  submissionAccess: roleIdsFromLocalStorage
    ? setFormAndSubmissionAccess("submissionAccess", roleIdsFromLocalStorage)
    : [],
  submissionAccessResource: roleIdsFromLocalStorage
    ? setFormAndSubmissionAccess(
        "submissionAccess",
        roleIdsFromLocalStorage,
        "resource"
      )
    : [],
  userDetail: null,
  isAuthenticated: false,
  currentPage: "",
  showApplications: false,
  lang: localStorage.getItem("lang") ? localStorage.getItem("lang") : LANGUAGE,
  selectLanguages: getLanguages ? JSON.parse(getLanguages) : [],
  forbiddenModal: {
    isOpen: false,
    type: "",
    requiredAssuranceLevel: null,
  },
};

const user = (state = initialState, action) => {
  switch (action.type) {
    case ACTION_CONSTANTS.SET_CURRENT_PAGE:
      return { ...state, currentPage: action.payload };
    case ACTION_CONSTANTS.SET_USER_TOKEN:
      localStorage.setItem("authToken", action.payload.token);
      localStorage.setItem("refreshToken", action.payload.refreshToken);
      localStorage.removeItem("logout-event");
      return {
        ...state,
        bearerToken: action.payload.token,
        refreshToken: action.payload.token,
        tokenParsed: action.payload.tokenParsed,
      };
    case ACTION_CONSTANTS.SET_USER_ROLES:
      return { ...state, roles: action.payload };
    case ACTION_CONSTANTS.SET_USER_DETAILS:
      return {
        ...state,
        userDetail: action.payload,
        showApplications: setShowApplications(action.payload?.groups || []),
      };
    case ACTION_CONSTANTS.SET_USER_AUTHENTICATION:
      return { ...state, isAuthenticated: action.payload };
    case ACTION_CONSTANTS.SET_LANGUAGE:
      localStorage.setItem("lang", action.payload);
      return { ...state, lang: action.payload };
    case ACTION_CONSTANTS.SET_SELECT_LANGUAGES:
      localStorage.setItem("languages", JSON.stringify(action.payload));
      return { ...state, selectLanguages: action.payload };
    case ACTION_CONSTANTS.ROLE_IDS:
      return { ...state, roleIds: setUserRolesToObject(action.payload) };
    case ACTION_CONSTANTS.ACCESS_ADDING:
      return {
        ...state,
        formAccess: setFormAndSubmissionAccess("formAccess", action.payload),
        submissionAccess: setFormAndSubmissionAccess(
          "submissionAccess",
          action.payload
        ),
        submissionAccessResource: setFormAndSubmissionAccess(
          "submissionAccess",
          action.payload,
          "resource"
        ),
      };
    case ACTION_CONSTANTS.OPEN_CLOSE_FORBIDDEN_MODAL:
      return { ...state, forbiddenModal: action.payload };
    default:
      return state;
  }
};

export default user;
