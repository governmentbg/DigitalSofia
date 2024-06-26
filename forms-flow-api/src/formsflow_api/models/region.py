import sys

from flask import current_app

from .base_model import BaseModel
from .audit_mixin import AuditDateTimeMixin
from .db import db


ADDITIONAL_REGION_DATA = {
    1: {
        "code": 522,
        "eik": "0006963270461",
        "id": "b776f6ae-e43f-4267-a20e-e490b8d9dcbd",
        "title": "Районна администрация - Средец",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2006,
        "mateus_eserviceClientId": "testAISClient"
    },
    2: {
        "code": 523,
        "eik": "0006963270526",
        "id": "5fc55943-b9e7-4fd0-978b-756bf5f460aa",
        "title": "Районна администрация - Красно село",
        "eserviceClientId": "epayments_ais_client_fb9726d5-346f-4d22-9dda-ceb620edba90",
        "mateus_code": 2009,
        "mateus_eserviceClientId": "epayments_ais_client_fb9726d5-346f-4d22-9dda-ceb620edba90"
    },
    3: {
        "code": 524,
        "eik": "0006963270480",
        "id": "63480615-8bfd-4b98-8811-ba2ff8e47720",
        "title": "Районна администрация - Възраждане",
        "eserviceClientId": "epayments_ais_client_6b6fd17e-dd18-48b0-b1bf-86239dfa04d6",
        "mateus_code": 2043,
        "mateus_eserviceClientId": "epayments_ais_client_6b6fd17e-dd18-48b0-b1bf-86239dfa04d6"
    },
    4: {
        "code": 525,
        "eik": "0006963270511",
        "id": "d9e5bf6a-f947-4180-a359-7b3a6673fb2d",
        "title": "Районна администрация - Оборище",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2015,
        "mateus_eserviceClientId": "testAISClient"
    },
    5: {
        "code": 526,
        "eik": "0006963270476",
        "id": "32094c2e-6090-4593-91fe-73fb1800495c",
        "title": "Районна администрация - Сердика",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2044,
        "mateus_eserviceClientId": "testAISClient"
    },
    6: {
        "code": 527,
        "eik": "0006963270530",
        "id": "ae688df5-8f0b-461d-82cc-855ec29eae29",
        "title": "Районна администрация - Подуяне",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2020,
        "mateus_eserviceClientId": "testAISClient"
    },
    7:{
        "code": 528,
        "eik": "0006963270545",
        "id": "958bd74f-15ef-4546-ba30-3d63f4523871",
        "title": "Районна администрация - Слатина",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2045,
        "mateus_eserviceClientId": "testAISClient"
    },
    8: {
        "code": 529,
        "eik": "0006963270550",
        "id": "5a4ab6ad-969d-4aa4-844b-b36505d29ef3",
        "title": "Районна администрация - Изгрев",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2047,
        "mateus_eserviceClientId": "testAISClient"
    },
    9: {
        "code": 530,
        "eik": "0006963270564",
        "id": "0ba20c11-f346-4a6d-abae-e315db607132",
        "title": "Районна администрация - Лозенец",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2025,
        "mateus_eserviceClientId": "testAISClient"
    },
    10: {
        "code": 531,
        "eik": "0006963270507",
        "id": "84484d6f-731e-46b8-baaa-b432fd80b363",
        "title": "Районна администрация - Триадица",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2006,
        "mateus_eserviceClientId": "testAISClient"
    },
    11: {
        "code": 532,
        "eik": "0006963270579",
        "id": "c6b1fdfe-bdd3-44dd-b01a-26a2e909b866",
        "title": "Районна администрация - Красна поляна",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2014,
        "mateus_eserviceClientId": "testAISClient"
    },
    12: {
        "code": 533,
        "eik": "0006963270583",
        "id": "676e3f8b-b8db-4ba2-8411-c5d6902b5347",
        "title": "Районна администрация - Илинден",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2007,
        "mateus_eserviceClientId": "testAISClient"
    },
    13: {
        "code": 534,
        "eik": "0006963270598",
        "id": "39ba0a95-ba1d-4d1d-b288-75184a2e928e",
        "title": "Районна администрация - Надежда",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2013,
        "mateus_eserviceClientId": "testAISClient"
    },
    14: {
        "code": 535,
        "eik": "0006963270603",
        "id": "e14489f6-fa78-4f75-bc83-6c82bd3d8bba",
        "title": "Районна администрация - Искър",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2005,
        "mateus_eserviceClientId": "testAISClient"
    },
    15: {
        "code": 536,
        "eik": "0006963270614",
        "id": "514a1c66-0465-4a5f-a522-1f6f8a7b473e",
        "title": "Районна администрация - Младост",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2046,
        "mateus_eserviceClientId": "testAISClient"
    },
    16: {
        "code": 537,
        "eik": "0006963270629",
        "id": "c80290e5-b5d5-4106-923d-5fad7c54f252",
        "title": "Районна администрация - Студентски",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2024,
        "mateus_eserviceClientId": "epayments_ais_client_99c19d9f-6c38-4cae-8af3-f738bea88d2f"
    },
    17: {
        "code": 538,
        "eik": "0006963270633",
        "id": "9ae3f943-e3c1-42eb-b3b1-dc1ef10cfd50",
        "title": "Районна администрация - Витоша",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2038,
        "mateus_eserviceClientId": "epayments_ais_client_6b45ba5c-3571-4897-b648-e0d19253a38c"
    },
    18: {
        "code": 539,
        "eik": "0006963270648",
        "id": "c13a9d40-2892-4b33-8d52-b7d998fb5492",
        "title": "Районна администрация - Овча купел",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2038,
        "mateus_eserviceClientId": "epayments_ais_client_6b45ba5c-3571-4897-b648-e0d19253a38c"
    },
    19: {
        "code": 540,
        "eik": "0006963270652",
        "id": "2e92a59f-90b0-4f3a-b80d-8710bb9284d9",
        "title": "Районна администрация - Люлин",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2018,
        "mateus_eserviceClientId": "testAISClient"
    },
    20: {
        "code": 541,
        "eik": "0006963270667",
        "id": "0aeda2b9-4ad3-47a5-b3e5-29c13bf82333",
        "title": "Районна администрация - Връбница",
        "eserviceClientId": "epayments_ais_client_5046e28e-193b-425d-a0f2-e7145581d59f",
        "mateus_code": 2013,
        "mateus_eserviceClientId": "epayments_ais_client_5046e28e-193b-425d-a0f2-e7145581d59f"
    },
    21: {
        "code": 542,
        "eik": "0006963270671",
        "id": "405590af-b287-4803-8a77-ce89ea21cd9e",
        "title": "Районна администрация - Нови Искър",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2031,
        "mateus_eserviceClientId": "testAISClient"
    },
    22: {
        "code": 543,
        "eik": "0006963270686",
        "id": "e306fe5f-34a7-4955-97c7-bc725bf865fc",
        "title": "Районна администрация - Кремиковци",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2008,
        "mateus_eserviceClientId": "testAISClient"

    },
    23: {
        "code": 544,
        "eik": "0006963270690",
        "id": "4faefb19-e75b-4308-9e57-5e887fbf1181",
        "title": "Районна администрация - Панчарево",
        "eserviceClientId": "testAISClient",
        "mateus_code": 2027,
        "mateus_eserviceClientId": "testAISClient"
    },
    24: {
        "code": 545,
        "eik": "0006963270495",
        "id": "424c725b-a4d8-483d-bf94-6f38bfe85a75",
        "title": "Районна администрация - Банкя",
        "eserviceClientId": "epayments_ais_client_5a341cc5-b3a8-47cf-8027-249079403b02",
        "mateus_code": 2019,
        "mateus_eserviceClientId": "epayments_ais_client_5a341cc5-b3a8-47cf-8027-249079403b02"
    }
}


class Region(AuditDateTimeMixin,
             BaseModel,
             db.Model):
    name = db.Column(db.String, nullable=False)
    code = db.Column(db.String, nullable=False)
    city_are_code = db.Column(db.Integer, primary_key=True)
    reference_number_code = db.Column(db.String, nullable=False)

    @staticmethod
    def create_from_dict(region_info: dict):
        try:
            region = Region()

            region.name = region_info["name"]
            region.code = region_info["code"]
            region.city_are_code = region_info["city_are_code"]
            region.reference_number_code = region_info["reference_number_code"]
            region.save()
            return region
        except:
            current_app.logger.info(sys.exc_info()[0])
            return None

    @staticmethod
    def delete_all():
        try:
            num_rows_deleted = db.session.query(Region).delete()
            db.session.commit()
            return num_rows_deleted
        except:
            db.session.rollback()
            return sys.exc_info()[0]

    @classmethod
    def get_all(cls):
        return cls.query.all()
