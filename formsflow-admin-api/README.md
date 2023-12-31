# Formsflow Admin

Admin services for formsflow.ai


## Development Setup

1. Open the project in VS Code to treat it as a project (or WSL projec). To prevent version clashes, set up a
virtual environment to install the Python packages used by this project.
2. Run `make setup` to set up the virtual environment and install libraries.
3. Next run `pip install .` to set up the environment for running tests.

You also need to set up the variables used for environment-specific settings:
1. Copy the [dotenv template file](dotenv_template) to somewhere above the source code and rename to `.env`. You will need to fill in missing values.

## Running the Database on localhost

To prepare your local database:
1. In the [root project folder](../docker/docker-compose.yml): `docker-compose up -d`
2. In your `venv` environment: 
```
export FLASK_APP=manage.py 
flask db upgrade
```


## Running API

1. Start the flask server with `(python -m flask run -p 5000)`
2. View the [OpenAPI Docs](http://127.0.0.1:5000/api/v1).

## Running Liniting

1. Run `make flake8` or `flake8 src/admin_api tests`.
2. Run `make pylint` or `pylint --rcfile=setup.cfg --disable=C0301,W0511 src/admin_api test`

## Running Unit Tests

1. Tests are run from the Status bar at the bottom of the workbench in VS Code or `pytest` command.
2. Next run `make coverage` to generate the coverage report, which appears in the *htmlcov* directory.

## Multi Tenancy Setup
Each tenant gets it's own keycloak clients to login.
Keycloak Setup:
- Create `forms-flow-web` client
- Create `camunda-admin` role under `forms-flow-web` client and assign to any super admin users.
- Configure KEYCLOAK_WEB_CLIENTID to `forms-flow-web` for bpm.
- Set KEYCLOAK_ENABLE_CLIENT_AUTH as true for bpm
- Set MULTI_TENANCY_ENABLED as true for bpm
- Set FORMSFLOW_ADMIN_URL to the admin API url 
