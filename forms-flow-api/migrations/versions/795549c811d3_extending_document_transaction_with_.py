"""Extending document transaction with origin form formio id

Revision ID: 795549c811d3
Revises: f1c985231b00
Create Date: 2023-12-01 14:40:06.926489

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '795549c811d3'
down_revision = 'f1c985231b00'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.add_column('document_transaction', sa.Column('origin_form_formio_id', sa.String(length=24), nullable=True))
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_column('document_transaction', 'origin_form_formio_id')
    # ### end Alembic commands ###