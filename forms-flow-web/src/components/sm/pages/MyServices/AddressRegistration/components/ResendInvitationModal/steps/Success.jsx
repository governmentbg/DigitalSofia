import React from "react";
import Modal from "react-bootstrap/Modal";
import CloseIcon from "@mui/icons-material/Close";
import VerifiedOutlinedIcon from "@mui/icons-material/VerifiedOutlined";
import { useTranslation } from "react-i18next";

import SmCta, {
  SmCtaTypes,
  SmCtaSizes,
} from "../../../../../../components/buttons/SmCta";

import styles from "../resendInvitationModal.module.scss";

const SuccessStep = ({ onClose }) => {
  const { t } = useTranslation();
  return (
    <div>
      <div className={styles.modalCloseCta}>
        <SmCta
          size={SmCtaSizes.SMALL}
          type={SmCtaTypes.OUTLINE}
          onClick={onClose}
          accessibilityProps={{
            "aria-label": t("screen.reader.modal.close.cta"),
          }}
        >
          <CloseIcon />
        </SmCta>
      </div>
      <div className={styles.modalContentContainer}>
        <Modal.Header className={styles.modalHeader}>
          <Modal.Title id="modal-title">
            {t("myServices.resendInvitation.success.modal.title")}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body className={styles.modalBody}>
          <div className="d-flex justify-content-center align-items-center w-100">
            <div
              className={`sm-rounded-wrapper bg-sm-blue text-white mb-5 mr-0`}
            >
              <VerifiedOutlinedIcon />
            </div>
          </div>
          <p>{t("myServices.resendInvitation.success.modal.message")}</p>
        </Modal.Body>
        <Modal.Footer className={styles.modalFooter}>
          <SmCta
            size={SmCtaSizes.SMALL}
            type={SmCtaTypes.SECONDARY}
            onClick={onClose}
            className={styles.confirmCta}
          >
            {t("modal.cta.confirm")}
          </SmCta>
        </Modal.Footer>
      </div>
    </div>
  );
};

export default SuccessStep;
